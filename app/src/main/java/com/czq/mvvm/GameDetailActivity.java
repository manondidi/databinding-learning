package com.czq.mvvm;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.czq.mvvm.ItemBinder.CommentItemBinder;
import com.czq.mvvm.ItemBinder.EmptyTransparentItemBinder;
import com.czq.mvvm.ItemBinder.EntryItemBinder;
import com.czq.mvvm.ItemBinder.PlayStatusItemBinder;
import com.czq.mvvm.ItemBinder.RecordTotalItemBinder;
import com.czq.mvvm.ItemBinder.ScreenshotBinder;
import com.czq.mvvm.busEvent.BusAction;
import com.czq.mvvm.converter.GameDetailConverter;
import com.czq.mvvm.converter.GameInfoConverter;
import com.czq.mvvm.databinding.ActivityGameDetailBinding;
import com.czq.mvvm.model.GameInfo;
import com.czq.mvvm.model.Screenshot;
import com.czq.mvvm.util.DenyUtil;
import com.czq.mvvm.util.MotionMoveUtil;
import com.czq.mvvm.viewModel.CommentItemVm;
import com.czq.mvvm.viewModel.EmptyTransparentItemVm;
import com.czq.mvvm.viewModel.EntryItemVm;
import com.czq.mvvm.viewModel.GameDetailVm;
import com.czq.mvvm.viewModel.PlayStatusItemVm;
import com.czq.mvvm.viewModel.RecordTotalItemVm;
import com.czq.mvvm.viewModel.TwoWayResultVm;
import com.gyf.barlibrary.ImmersionBar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;
import me.drakeet.multitype.MultiTypeAdapter;
import me.everything.android.ui.overscroll.IOverScrollDecor;
import me.everything.android.ui.overscroll.IOverScrollUpdateListener;
import me.everything.android.ui.overscroll.VerticalOverScrollBounceEffectDecorator;
import me.everything.android.ui.overscroll.adapters.RecyclerViewOverScrollDecorAdapter;

import static me.everything.android.ui.overscroll.IOverScrollState.STATE_BOUNCE_BACK;

public class GameDetailActivity
        extends AppCompatActivity implements GameDetailContact.IGameDetailView {
    private ActivityGameDetailBinding binding;
    private MultiTypeAdapter commmentAdapter = new MultiTypeAdapter();
    List dataSource = new ArrayList();
    private ImmersionBar mImmersionBar;
    List screenshots = new ArrayList();
    private MultiTypeAdapter screenshotsAdapter = new MultiTypeAdapter();
    private GameDetailVm mGameDetailVm;
    private GameDetailPresenter mPresenter;
    private GameInfo mGameInfo;
    private MotionMoveUtil mMotionMoveUtil;


    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        mPresenter = new GameDetailPresenter(this, new MockService(this));
        mMotionMoveUtil = new MotionMoveUtil();
        binding = ((ActivityGameDetailBinding) DataBindingUtil.setContentView(this, R.layout.activity_game_detail));
        initView();
        mPresenter.start();
    }

    private void initView() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
        binding.rcComment.setLayoutManager(new LinearLayoutManager(this));
        binding.rcComment.setAdapter(commmentAdapter);
        commmentAdapter.register(EmptyTransparentItemVm.class, new EmptyTransparentItemBinder());
        commmentAdapter.register(CommentItemVm.class, new CommentItemBinder());
        commmentAdapter.register(EntryItemVm.class, new EntryItemBinder());
        commmentAdapter.register(PlayStatusItemVm.class, new PlayStatusItemBinder());
        commmentAdapter.register(RecordTotalItemVm.class, new RecordTotalItemBinder());
        binding.subViewGameInfo.rcScreenshots.setAdapter(screenshotsAdapter);
        binding.subViewGameInfo.rcScreenshots.setLayoutManager(new LinearLayoutManager(this, 0, false));
        screenshotsAdapter.register(Screenshot.class, new ScreenshotBinder());
        binding.rcComment.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt) {
                super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
            }

            public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2) {
                super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
                binding.scrollView.scrollBy(paramAnonymousInt1, paramAnonymousInt2 / 3);
                paramAnonymousInt1 = getScollYDistance();
                if (paramAnonymousInt1 < 100) {
                    binding.toolbarContain.setAlpha(paramAnonymousInt1 / 100.0F);
                    binding.ivToolbar.setAlpha(paramAnonymousInt1 / 100.0F);
                    return;
                }
                if (binding.toolbarContain.getAlpha() != 1.0F) {
                    binding.toolbarContain.setAlpha(1.0F);
                    binding.ivToolbar.setAlpha(1.0F);
                }
            }
        });
        new VerticalOverScrollBounceEffectDecorator(new RecyclerViewOverScrollDecorAdapter(binding.rcComment)).setOverScrollUpdateListener(new IOverScrollUpdateListener() {
            public void onOverScrollUpdate(IOverScrollDecor decor, int state, float offset) {
                if (state == STATE_BOUNCE_BACK && (offset > 200.0F) && (binding.rcComment.getVisibility() == View.VISIBLE)) {
                    EventBus.getDefault().post(new BusAction.HideCommentRecyclerViewEvent(offset));
                }
            }
        });


    }


    protected void onDestroy() {
        super.onDestroy();
        mPresenter = null;
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(BusAction.GameDetailStatusClickEvent event) {
        Intent i = new Intent(this, TwoWayActivity.class);
        i.putExtra("gameInfo", mGameInfo);
        startActivityForResult(i, 1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1234) {
            TwoWayResultVm twoWayResultVm = (TwoWayResultVm) data.getSerializableExtra("twoWayResultVm");
            setGameInfo(GameInfoConverter.converTwoWayGameInfo(twoWayResultVm, mGameInfo));
            GameDetailVm gameDetailVm = GameDetailConverter.converGameDetailVm(mGameInfo, twoWayResultVm, mGameDetailVm);
            setGameDetailVm(gameDetailVm);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(BusAction.HideCommentRecyclerViewEvent event) {

        final ValueAnimator animator = ValueAnimator.ofFloat(event.startPositionX, getResources().getDisplayMetrics().heightPixels);
        animator.setDuration(400);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                binding.rcComment.setTranslationY((Float) animation.getAnimatedValue());
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                binding.rcComment.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
    }


    public void showCommentRecyclerView(View paramView) {
        binding.rcComment.setVisibility(View.VISIBLE);
        binding.rcComment.smoothScrollToPosition(0);
        binding.scrollView.smoothScrollTo(0, 0);
        (new SpringAnimation(binding.rcComment, DynamicAnimation.TRANSLATION_Y, 0.0F).setSpring(new SpringForce(0.0F).setDampingRatio(0.75F).setStiffness(200.0F)).setStartValue(getResources().getDisplayMetrics().heightPixels)).setStartVelocity(100.0F).start();
    }

    private int getScollYDistance() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) binding.rcComment.getLayoutManager();
        int position = linearLayoutManager.findFirstVisibleItemPosition();
        View firstVisiableChildView = linearLayoutManager.findViewByPosition(position);
        int itemHeight = firstVisiableChildView.getHeight();
        return DenyUtil.px2dip(this, (position) * itemHeight - firstVisiableChildView.getTop());
    }

    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void setGameDetailVm(GameDetailVm gameDetailVm) {
        mGameDetailVm = gameDetailVm;
        dataSource = gameDetailVm.datasource;
        commmentAdapter.setItems(dataSource);
        commmentAdapter.notifyDataSetChanged();

        screenshotsAdapter.setItems(gameDetailVm.screenshotVm.screenshots);
        screenshotsAdapter.notifyDataSetChanged();
        binding.setGameDetailVm(mGameDetailVm);

        Glide.with(this).load(R.mipmap.default_screenshot).apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 3))).into(binding.ivToolbar);


    }

    @Override
    public void setGameInfo(GameInfo gameInfo) {
        mGameInfo = gameInfo;
    }
}
