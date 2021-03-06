package flowless;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;

/**
 * Created by Zhuinden on 2016.05.26..
 */
public class ActivityUtils {
    private static final String TAG = "ActivityUtils";

    public static Activity getActivity(Context context) {
        if(context instanceof Activity) {
            return (Activity) context;
        } else if(context instanceof ContextWrapper) {
            if(context instanceof FlowContextWrapper) {
                FlowContextWrapper flowContextWrapper = (FlowContextWrapper) context;
                Context baseContext = flowContextWrapper.getBaseContext();
                if(baseContext instanceof InternalContextWrapper) {
                    return InternalContextWrapper.getActivity(baseContext);
                }
            } else if(context instanceof InternalContextWrapper) {
                return InternalContextWrapper.getActivity(context);
            } else {
                Context baseContext = ((ContextWrapper) context).getBaseContext();
                if(baseContext instanceof Activity) {
                    return (Activity) baseContext;
                }
            }
        }
        Log.e(TAG, "No activity could be found in [" + context + "]");
        throw new IllegalStateException("No activity could be found in [" + context + "]");
    }
}
