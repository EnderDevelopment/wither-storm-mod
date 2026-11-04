package com.enderdevelopment.witherstorm.entity;

import com.enderdevelopment.witherstorm.WitherStormMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.World;

public class WitherStormEntity extends HostileEntity {
    public WitherStormEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        if (world instanceof ServerWorld) {
            this.setPersistent();
        }
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder createWitherStormAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 300.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.6D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15.0D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 40.0D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0D);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.75D));
        this.goalSelector.add(3, new LookAroundGoal(this));
        this.goalSelector.add(4, new WitherStormAttackGoal(this));
    }

    @Override
    public boolean canTarget(EntityType<?> type) {
        return true;
    }
}