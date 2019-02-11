package org.wikipedia.page.action;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatImageView;
import android.text.SpannableStringBuilder;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowHandler;
import org.robolectric.shadows.ShadowToast;
import org.wikipedia.R;
import org.wikipedia.page.PageActivity;
import org.wikipedia.page.PageFragment;

import android.support.v4.app.Fragment;

import static android.net.sip.SipErrorCode.TIME_OUT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
public class PageActionTabTest {

    Activity activity;
    Fragment fragment;
//    @Before
//    public void setUp() throws Exception {
//        activity = Robolectric.buildActivity(PageActivity.class)
//                .create()
//                .resume()
//                .get();
//        FragmentManager manager = fragment.getFragmentManager();
//        fragment = (PageFragment) manager.findFragmentById(R.id.page_fragment);
//    }

    @Test
    public void testTextToSpeechButton() {
//
//        PageFragment yourFragment = new PageFragment();
//        startFragment( yourFragment );
//        assertNotNull( yourFragment );
//
//        Button button = (Button) yourFragment.getView().findViewById(R.id.article_menu_text_to_speech);
////        AppCompatImageView button = (AppCompatImageView) findViewById(R.id.article_menu_text_to_speech);
//        button.performClick();
//        ShadowHandler.idleMainLooper();
//        Assert.assertEquals( ShadowToast.getTextOfLatestToast(), "Execution of Text-To-Speech");


    }

//    public static void startFragment( Fragment fragment )
//    {
//        FragmentManager fragmentManager = new FragmentActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add( fragment, null );
//        fragmentTransaction.commit();
//    }

}
