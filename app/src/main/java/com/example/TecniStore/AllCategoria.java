package com.example.TecniStore;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.TecniStore.adapter.AllCategoryAdapter;
import com.example.TecniStore.modelo.AllCategoryModel;

import com.example.TecniStore.R.*;

import java.util.ArrayList;
import java.util.List;

public class AllCategoria extends AppCompatActivity {

    private RecyclerView AllCategoryRecycler;
    private AllCategoryAdapter allCategoryAdapter;
    private List<AllCategoryModel> allCategoryModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_catecoria);

        AllCategoryRecycler = findViewById(R.id.all_category);

        // adding data to model
        allCategoryModelList = new ArrayList<>();
        allCategoryModelList.add(new AllCategoryModel(1, drawable.ico_categoria_celular));
        allCategoryModelList.add(new AllCategoryModel(2, R.drawable.ico_categoria_celular));
        allCategoryModelList.add(new AllCategoryModel(3, R.drawable.ico_categoria_celular));
        allCategoryModelList.add(new AllCategoryModel(4, R.drawable.ico_categoria_celular));
        allCategoryModelList.add(new AllCategoryModel(5, R.drawable.ico_categoria_celular));
        allCategoryModelList.add(new AllCategoryModel(6, R.drawable.ico_categoria_celular));
        allCategoryModelList.add(new AllCategoryModel(7, R.drawable.ico_categoria_celular));
        allCategoryModelList.add(new AllCategoryModel(8, R.drawable.ico_categoria_celular));
        allCategoryModelList.add(new AllCategoryModel(8, R.drawable.ico_categoria_celular));


        setCategoryRecycler(allCategoryModelList);

    }

    private void setCategoryRecycler(List<AllCategoryModel> allcategoryModelList) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 4);
        AllCategoryRecycler.setLayoutManager(layoutManager);
        AllCategoryRecycler.addItemDecoration(new GridSpacingItemDecoration(4, dpToPx(16), true));
        AllCategoryRecycler.setItemAnimator(new DefaultItemAnimator());
        allCategoryAdapter = new AllCategoryAdapter(this,allcategoryModelList);
        AllCategoryRecycler.setAdapter(allCategoryAdapter);
    }

    // now we need some item decoration class for manage spacing

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }


}