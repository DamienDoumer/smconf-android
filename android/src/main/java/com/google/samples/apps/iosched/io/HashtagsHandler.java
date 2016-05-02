/*
 * Copyright 2014 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.iosched.io;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;

import com.google.samples.apps.iosched.io.model.Hashtag;
import com.google.samples.apps.iosched.provider.ScheduleContract;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.samples.apps.iosched.provider.ScheduleContractHelper;
<<<<<<< HEAD
=======
import com.google.samples.apps.iosched.util.LogUtils;
>>>>>>> ioschedLarry/master

import java.util.ArrayList;
import java.util.HashMap;

import static com.google.samples.apps.iosched.util.LogUtils.LOGD;
import static com.google.samples.apps.iosched.util.LogUtils.makeLogTag;

public class HashtagsHandler extends JSONHandler {

<<<<<<< HEAD
    private static final String TAG = makeLogTag(HashtagsHandler.class);
=======
    private static final String TAG = LogUtils.makeLogTag(HashtagsHandler.class);
>>>>>>> ioschedLarry/master
    private HashMap<String, Hashtag> mHashtags = new HashMap<String, Hashtag>();

    public HashtagsHandler(Context context) {
        super(context);
    }

    @Override
    public void process(JsonElement element) {
<<<<<<< HEAD
        LOGD(TAG, "process");
=======
        LogUtils.LOGD(TAG, "process");
>>>>>>> ioschedLarry/master
        for (Hashtag hashtag : new Gson().fromJson(element, Hashtag[].class)) {
            mHashtags.put(hashtag.name, hashtag);
        }
    }

    @Override
    public void makeContentProviderOperations(ArrayList<ContentProviderOperation> list) {
<<<<<<< HEAD
        LOGD(TAG, "makeContentProviderOperations");
=======
        LogUtils.LOGD(TAG, "makeContentProviderOperations");
>>>>>>> ioschedLarry/master
        Uri uri = ScheduleContractHelper.setUriAsCalledFromSyncAdapter(
                ScheduleContract.Hashtags.CONTENT_URI);
        // Remove all the current entries
        list.add(ContentProviderOperation.newDelete(uri).build());
        // Insert hashtags
        for (Hashtag hashtag : mHashtags.values()) {
            ContentProviderOperation.Builder builder = ContentProviderOperation.newInsert(uri);
            builder.withValue(ScheduleContract.Hashtags.HASHTAG_NAME, hashtag.name);
            builder.withValue(ScheduleContract.Hashtags.HASHTAG_DESCRIPTION, hashtag.description);
            try {
                builder.withValue(ScheduleContract.Hashtags.HASHTAG_COLOR,
                        Color.parseColor(hashtag.color));
            } catch (IllegalArgumentException e) {
                builder.withValue(ScheduleContract.Hashtags.HASHTAG_COLOR, Color.BLACK);
            }
            builder.withValue(ScheduleContract.Hashtags.HASHTAG_ORDER, hashtag.order);
            list.add(builder.build());
        }
<<<<<<< HEAD
        LOGD(TAG, "Hashtags: " + mHashtags.size());
=======
        LogUtils.LOGD(TAG, "Hashtags: " + mHashtags.size());
>>>>>>> ioschedLarry/master
    }

}
