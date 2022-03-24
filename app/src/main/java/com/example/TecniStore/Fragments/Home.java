package com.example.TecniStore.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.TecniStore.R;
import com.example.TecniStore.adapter.CategoryAdapter;
import com.example.TecniStore.api.servicioApi;
import com.example.TecniStore.modelo.Categoria;

import static com.example.TecniStore.R.drawable.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private CategoryAdapter categoryAdapter;
    private List<Categoria> categoryList;
    private RecyclerView  list_categorias;
    private View view;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView listaProdcutos= view.findViewById(R.id.listaProductos);
        servicioApi api= new servicioApi(view.getContext(), listaProdcutos);

        list_categorias= view.findViewById(R.id.itemsCategoria);

        /*Cargo info de las categorias*/
        categoryList = new ArrayList<Categoria>();
        categoryList.add(new Categoria(1, ico_categoria_celular));
        categoryList.add(new Categoria(2, ic_home_fruits));
        categoryList.add(new Categoria(3, ic_home_fruits));
        categoryList.add(new Categoria(4, ic_home_fruits));
        categoryList.add(new Categoria(5, ic_home_fruits));
        categoryList.add(new Categoria(6, ic_home_fruits));

        setCategoryRecycler(categoryList);

        return view;
    }

    private void setCategoryRecycler(List<Categoria> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        list_categorias.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(view.getContext(),categoryDataList);
        list_categorias.setAdapter(categoryAdapter);
    }
}