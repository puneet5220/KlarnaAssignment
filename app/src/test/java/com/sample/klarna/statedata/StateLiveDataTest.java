package com.sample.klarna.statedata;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class StateLiveDataTest {

    @Rule
    public InstantTaskExecutorRule mInstantTaskExecutorRule = new InstantTaskExecutorRule();
    @Mock
    private Throwable mThrowable;
    @Mock
    SampleDataModel sampleDataModel;


    private StateLiveData<SampleDataModel> mStateLiveData;

    @Before
    public void init() {
        mStateLiveData = new StateLiveData<>();
    }

    @Test
    public void postComplete_returnStatusAsSuccess() {
        mStateLiveData.postSuccess(sampleDataModel);

        assertEquals(StateData.DataStatus.SUCCESS, mStateLiveData.getValue().getStatus());
    }

    @Test
    public void postError_returnStatusAsError() {
        mStateLiveData.postError(mThrowable);

        assertEquals(StateData.DataStatus.ERROR, mStateLiveData.getValue().getStatus());
    }
}
