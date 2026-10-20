package com.f2d.decoplus.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.util.RandomSource;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.function.Function;

public class VmonitorBlock extends Block implements SimpleWaterloggedBlock {
	public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private final Function<BlockState, VoxelShape> shapes = this.makeShapes();

	public VmonitorBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.CANDLE).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	private Function<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				case NORTH -> Shapes.or(box(1.5, 1, 7.49974, 9, 16, 8.49974), box(2, 0, 8, 6, 1, 10), box(6, 0, 8, 10, 1, 10), box(5, 0, 9, 7, 8, 10), box(5.4, 4.65, 0.4, 8.6, 6.85, 2.6), box(8.5, 4.75, 0.5, 10.5, 6.75, 2.5));
				case EAST -> Shapes.or(box(7.50026, 1, 1.5, 8.50026, 16, 9), box(6, 0, 2, 8, 1, 6), box(6, 0, 6, 8, 1, 10), box(6, 0, 5, 7, 8, 7), box(13.4, 4.65, 5.4, 15.6, 6.85, 8.6), box(13.5, 4.75, 8.5, 15.5, 6.75, 10.5));
				case WEST -> Shapes.or(box(7.49974, 1, 7, 8.49974, 16, 14.5), box(8, 0, 10, 10, 1, 14), box(8, 0, 6, 10, 1, 10), box(9, 0, 9, 10, 8, 11), box(0.4, 4.65, 7.4, 2.6, 6.85, 10.6), box(0.5, 4.75, 5.5, 2.5, 6.75, 7.5));
				default -> Shapes.or(box(7, 1, 7.50026, 14.5, 16, 8.50026), box(10, 0, 6, 14, 1, 8), box(6, 0, 6, 10, 1, 8), box(9, 0, 6, 11, 8, 7), box(7.4, 4.65, 13.4, 10.6, 6.85, 15.6), box(5.5, 4.75, 13.5, 7.5, 6.75, 15.5));
			};
		}, WATERLOGGED);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.apply(state);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightDampening(BlockState state) {
		return propagatesSkylightDown(state) ? 0 : 1;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return state.setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, LevelReader world, ScheduledTickAccess scheduledTickAccess, BlockPos currentPos, Direction facing, BlockPos facingPos, BlockState facingState, RandomSource random) {
		if (state.getValue(WATERLOGGED)) {
			scheduledTickAccess.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, world, scheduledTickAccess, currentPos, facing, facingPos, facingState, random);
	}
}