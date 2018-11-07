package com.dexfun.yiku.utils;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;



/**
 * Created by Smile on 17/5/15.
 */

public class AnimatorUtils {

//    public static ObjectAnimator nope(View view) {
//        int delta = view.getResources().getDimensionPixelOffset(R.dimen.spacing_medium);
//
//        PropertyValuesHolder pvhTranslateX = PropertyValuesHolder.ofKeyframe(View.TRANSLATION_X,
//                Keyframe.ofFloat(0f, 0),
//                Keyframe.ofFloat(.10f, -delta),
//                Keyframe.ofFloat(.26f, delta),
//                Keyframe.ofFloat(.42f, -delta),
//                Keyframe.ofFloat(.58f, delta),
//                Keyframe.ofFloat(.74f, -delta),
//                Keyframe.ofFloat(.90f, delta),
//                Keyframe.ofFloat(1f, 0f)
//        );
//
//        return ObjectAnimator.ofPropertyValuesHolder(view, pvhTranslateX).
//                setDuration(500);
//    }

    private static final Interpolator INTERPOLATOR = new FastOutSlowInInterpolator();

    /**
     * Hide the quick return view.
     * <p>
     * Animates hiding the view, with the view sliding down and out of the screen.
     * After the view has disappeared, its visibility will change to GONE.
     *
     * @param view The quick return view
     */
    public static void hide(final View view) {
        ViewPropertyAnimator animator = view.animate()
                .translationX(-view.getWidth())
                .setInterpolator(INTERPOLATOR)
                .setDuration(250);

        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                // Prevent drawing the View after it is gone
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                // Canceling a hide should show the view

            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });

        animator.start();
    }

    public static void hideGo(final View view) {
        ViewPropertyAnimator animator = view.animate()
                .translationY(view.getWidth() + (view.getWidth()/2))
                .setInterpolator(INTERPOLATOR)
                .setDuration(250);

        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                // Prevent drawing the View after it is gone
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                // Canceling a hide should show the view

            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });

        animator.start();
    }

    /**
     * Show the quick return view.
     * <p>
     * Animates showing the view, with the view sliding up from the bottom of the screen.
     * After the view has reappeared, its visibility will change to VISIBLE.
     *
     * @param view The quick return view
     */
    public static void show(final View view) {

        ViewPropertyAnimator animator = view.animate()
                .translationX(0)
                .setInterpolator(INTERPOLATOR)
                .setDuration(250);

        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {
                // Canceling a show should hide the view

            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });

        animator.start();
    }

    public static void showGo(final View view) {

        ViewPropertyAnimator animator = view.animate()
                .translationY(0)
                .setInterpolator(INTERPOLATOR)
                .setDuration(250);

        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {
                // Canceling a show should hide the view

            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });

        animator.start();
    }

    public class SpringInterpolator implements Interpolator {

        public SpringInterpolator() {
        }

        public SpringInterpolator(Context context, AttributeSet attrs) {
        }

        @Override
        public float getInterpolation(float input) {
            return (float) Math.sin(input * 2 * Math.PI);
        }

    }

    public static class MyInterpolator implements Interpolator {
        @Override
        public float getInterpolation(float input) {
            float factor = 0.4f;

            return (float) (Math.pow(2, -10 * input) * Math.sin((input - factor / 4) * (2 * Math.PI) / factor) + 1);
        }

        float bounce(float t) {
            return t * t * 8;
        }


    }
}
