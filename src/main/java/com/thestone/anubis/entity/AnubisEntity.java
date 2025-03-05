package com.thestone.anubis.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Random;

public class AnubisEntity extends HostileEntity implements GeoEntity {
    private static final RawAnimation WALK_ANIMATION = RawAnimation.begin().thenLoop("walk");
    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");
    private static final RawAnimation ATTACK_ANIMATION_1 = RawAnimation.begin().thenPlay("attack_1");
    private static final RawAnimation ATTACK_ANIMATION_2 = RawAnimation.begin().thenPlay("attack_2");
    private static final RawAnimation ATTACK_ANIMATION_3 = RawAnimation.begin().thenPlay("attack_3");
    private static final RawAnimation ATTACK_ANIMATION_4 = RawAnimation.begin().thenPlay("attack_4");
    private static final RawAnimation ATTACK_ANIMATION_5 = RawAnimation.begin().thenPlay("attack_5");
    private static final RawAnimation ATTACK_ANIMATION_6 = RawAnimation.begin().thenPlay("attack_6");
    private static final RawAnimation ATTACK_ANIMATION_7 = RawAnimation.begin().thenPlay("attack_7");
    private static final RawAnimation DEAD_ANIMATION = RawAnimation.begin().thenPlay("dead");
    private final AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);


    private final ServerBossBar bossBar = new ServerBossBar(Text.literal("Anubis"),
            BossBar.Color.YELLOW, BossBar.Style.NOTCHED_10);

    public AnubisEntity(EntityType<? extends AnubisEntity> entityType, World world) {
        super(entityType, world);

    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0D)
                .add(EntityAttributes.GENERIC_ARMOR, 3.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0D)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23F)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0);
    }

    /**
     * TODO
     * Add custom attacks goals with custom animations.
     */
    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(4, new MeleeAttackGoal(this, 0.7D, false));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));

        this.goalSelector.add(6, new LookAroundGoal(this));

        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, MerchantEntity.class, false));

    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "MovingController", 0, this::movingPredicate));
        controllerRegistrar.add(new AnimationController<>(this, "AttackController", 0, this::attackPredicate));
        controllerRegistrar.add(new AnimationController<>(this, "DeadController", 0, this::deathPredicate));
    }


    private <E extends GeoAnimatable> PlayState attackPredicate(AnimationState<E> tAnimationState) {
        Random choose = new Random();
        if (this.handSwinging && tAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            tAnimationState.getController().forceAnimationReset();
            int randomIndex = choose.nextInt(7);
            switch (randomIndex) {
                case 0 -> tAnimationState.setAnimation(ATTACK_ANIMATION_1);
                case 1 -> tAnimationState.setAnimation(ATTACK_ANIMATION_2);
                case 2 -> tAnimationState.setAnimation(ATTACK_ANIMATION_3);
                case 3 -> tAnimationState.setAnimation(ATTACK_ANIMATION_4);
                case 4 -> tAnimationState.setAnimation(ATTACK_ANIMATION_5);
                case 5 -> tAnimationState.setAnimation(ATTACK_ANIMATION_6);
                case 6 -> tAnimationState.setAnimation(ATTACK_ANIMATION_7);

            }

            this.handSwinging = false;

        }
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState movingPredicate(AnimationState<E> tAnimationState) {
        return (tAnimationState.isMoving() ? tAnimationState.setAndContinue(WALK_ANIMATION) : tAnimationState.setAndContinue(IDLE_ANIMATION));


    }
        //todo Add workable dead animation
    private <E extends GeoAnimatable> PlayState deathPredicate(AnimationState<E> tAnimationState) {
        tAnimationState.setAndContinue(DEAD_ANIMATION);
        return this.isDead() ? PlayState.CONTINUE : PlayState.STOP;

    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animatableInstanceCache;
    }

    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);


    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    @Override
    protected void mobTick() {
        super.mobTick();
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }
}
