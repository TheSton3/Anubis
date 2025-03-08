package com.thestone.anubis.main;

import software.bernie.geckolib.core.animation.RawAnimation;

public class ModAninamtions {
    public static final RawAnimation WALK_ANIMATION = RawAnimation.begin().thenLoop("walk");
    public static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");
    public static final RawAnimation ATTACK_ANIMATION_1 = RawAnimation.begin().thenPlay("attack_1");
    public static final RawAnimation ATTACK_ANIMATION_2 = RawAnimation.begin().thenPlay("attack_2");
    public static final RawAnimation ATTACK_ANIMATION_3 = RawAnimation.begin().thenPlay("attack_3");
    public static final RawAnimation ATTACK_ANIMATION_4 = RawAnimation.begin().thenPlay("attack_4");
    public static final RawAnimation ATTACK_ANIMATION_5 = RawAnimation.begin().thenPlay("attack_5");
    public static final RawAnimation ATTACK_ANIMATION_6 = RawAnimation.begin().thenPlay("attack_6");
    public static final RawAnimation ATTACK_ANIMATION_7 = RawAnimation.begin().thenPlay("attack_7");
    public static final RawAnimation DEAD_ANIMATION = RawAnimation.begin().thenPlayAndHold("dead");
}
