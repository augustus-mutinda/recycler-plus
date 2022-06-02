package argon.digital.toolkit;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ToolKitRecyclerView extends RecyclerView {
    public ToolKitRecyclerView(@NonNull Context context) {
        super(context);
        this.setLayoutManager(new LinearLayoutManager(context));
    }

    public ToolKitRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setLayoutManager(new LinearLayoutManager(context));
    }

    public ToolKitRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setLayoutManager(new LinearLayoutManager(context));
    }
}
