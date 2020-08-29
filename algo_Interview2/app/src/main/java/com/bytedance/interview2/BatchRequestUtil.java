package com.bytedance.interview2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BatchRequestUtil {

    static class BooleanWrapper {
        boolean isMainReady = false;
    }

    private static void invokePengindResult(HashMap<Callback, Integer> pendingCallbacks, boolean isForceFailure) {
        if (pendingCallbacks == null) {
            return;
        }

        Set<Map.Entry<Callback, Integer>> set = pendingCallbacks.entrySet();
        for (Map.Entry<Callback, Integer> entry : set) {
            Callback callback = entry.getKey();
            int value = entry.getValue();
            if (callback != null) {
                if(isForceFailure) {
                    callback.onFailure();
                } else {
                    if (value != 0) {
                        callback.onSuccess();
                    } else {
                        callback.onFailure();
                    }
                }
            }
        }
    }

    //support main-sub requests dependency scenario
    //1.if any of sub requests come back first, then it should wait, and trigger callback after main request is done.
    //2.if main request fails, then sub requests should trigger onFailure() callback whatever themselves success or fail.
    public static void request(final Request mainRequest, final Callback mainCallback, final List<Request> subRequests, final List<Callback> subCallbacks) {
        //please fulfill code right here.

        final HashMap<Callback, Integer> pendingCallbacks = new HashMap<>();

        final BooleanWrapper wrapper = new BooleanWrapper();
        wrapper.isMainReady = false;

        ApiService.execute(mainRequest, new Callback() {
            @Override
            public void onSuccess() {
                wrapper.isMainReady = true;

                if (mainCallback != null) {
                    mainCallback.onSuccess();
                }

                invokePengindResult(pendingCallbacks, false);
            }

            @Override
            public void onFailure() {
                wrapper.isMainReady = true;

                if (mainCallback != null) {
                    mainCallback.onFailure();
                }

                invokePengindResult(pendingCallbacks, true);
            }
        });

        if ((subRequests != null) && (subRequests.size() != 0)) {
            for (int i = 0; i < subRequests.size(); i++) {
                final int temp = i;
                ApiService.execute(subRequests.get(i), new Callback() {
                    @Override
                    public void onSuccess() {
                        if (wrapper.isMainReady) {
                            subCallbacks.get(temp).onSuccess();
                        } else {
                            pendingCallbacks.put(subCallbacks.get(temp), 1);
                        }
                    }

                    @Override
                    public void onFailure() {
                        if (wrapper.isMainReady) {
                            subCallbacks.get(temp).onFailure();
                        } else {
                            pendingCallbacks.put(subCallbacks.get(temp), 0);
                        }
                    }
                });
            }
        }


    }

    interface Callback {
        void onSuccess();

        void onFailure();
    }

    class Request {
        String url;
    }

    static class ApiService {
        public static void execute(Request request, Callback callback) {
            //network request execution
        }
    }
}