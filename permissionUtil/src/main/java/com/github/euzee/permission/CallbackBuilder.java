package com.github.euzee.permission;

public class CallbackBuilder {

    private PermissionGranted granted;
    private PermissionDenied denied;
    private int titleId;
    private int messageId;

    public CallbackBuilder() {
    }

    public CallbackBuilder onGranted(PermissionGranted call) {
        granted = call;
        return this;
    }

    public CallbackBuilder onDenied(PermissionDenied call) {
        denied = call;
        return this;
    }

    public CallbackBuilder withRationale(int titleResId, int messageResId) {
        titleId = titleResId;
        messageId = messageResId;
        return this;
    }

    public PermissionCallback build() {
        return new PermissionCallback() {
            @Override
            public void onPermissionGranted() {
                if (granted != null)
                    granted.onPermissionGranted();
            }

            @Override
            public void onPermissionDenied() {
                if (denied != null)
                    denied.onPermissionDenied();
            }

            @Override
            public int getRationaleTitleId() {
                return titleId;
            }

            @Override
            public int getRationaleMessageId() {
                return messageId;
            }
        };
    }

}
