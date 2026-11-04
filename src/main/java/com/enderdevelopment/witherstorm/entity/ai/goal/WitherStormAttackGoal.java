package com.enderdevelopment.witherstorm.entity.ai.goal;

import com.enderdevelopment.witherstorm.entity.WitherStormEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.random.Random;

import java.util.EnumSet;

public class WitherStormAttackGoal extends Goal {
    private final WitherStormEntity witherStorm;
    private int attackCooldown;
    private final Random random = Random.create();

    public WitherStormAttackGoal(WitherStormEntity witherStorm) {
        this.witherStorm = witherStorm;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        return this.witherStorm.getTarget() != null && this.witherStorm.getTarget().isAlive();
    }

    @Override
    public void start() {
        this.attackCooldown = 0;
    }

    @Override
    public void tick() {
        PlayerEntity target = (PlayerEntity) this.witherStorm.getTarget();
        if (target != null) {
            this.witherStorm.getLookControl().lookAt(target, 30.0F, 30.0F);
            double distance = this.witherStorm.squaredDistanceTo(target);

            if (distance < 16.0D) {
                // Close range attacks
                if (this.attackCooldown <= 0) {
                    this.witherStorm.tryAttack(target);
                    this.attackCooldown = 20;
                } else {
                    this.attackCooldown--;
                }
            } else if (distance < 64.0D) {
                // Mid range attacks
                if (this.attackCooldown <= 0) {
                    // Choose a random attack
                    int attackType = this.random.nextInt(3);
                    switch (attackType) {
                        case 0:
                            WitherStormAbilities.tentacleSlap(this.witherStorm, target);
                            break;
                        case 1:
                            WitherStormAbilities.groundSlam(this.witherStorm);
                            break;
                        case 2:
                            WitherStormAbilities.playerCrushing(this.witherStorm, target);
                            break;
                    }
                    this.attackCooldown = 40;
                } else {
                    this.attackCooldown--;
                }
            } else {
                // Long range attacks
                if (this.attackCooldown <= 0) {
                    WitherStormAbilities.grabPlayer(this.witherStorm, target);
                    this.attackCooldown = 60;
                } else {
                    this.attackCooldown--;
                }
            }
        }
    }
}