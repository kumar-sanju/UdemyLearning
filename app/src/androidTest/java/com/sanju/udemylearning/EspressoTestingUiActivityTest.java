package com.sanju.udemylearning;

import androidx.test.rule.ActivityTestRule;

import junit.framework.TestCase;

import org.junit.Rule;

public class EspressoTestingUiActivityTest extends TestCase {

    @Rule
    public ActivityTestRule<EspressoTestingUiActivity> mActivityTestRule = new ActivityTestRule<EspressoTestingUiActivity>(EspressoTestingUiActivity.class);

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }
}