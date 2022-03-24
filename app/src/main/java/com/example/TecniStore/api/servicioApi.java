package com.example.TecniStore.api;

import android.content.Context;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.TecniStore.adapter.ProductoAdapter;
import com.example.TecniStore.modelo.Producto;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//import static com.example.tecnitienda.MainActivity.VARIABLE_GLOBAL;


public class servicioApi {

    ProductoAdapter productoAdapter;
    ArrayList<Producto> productos= new ArrayList<>();
    Context context;
    RecyclerView listProductos;

    public servicioApi() {

    }

    public servicioApi(Context context, RecyclerView listProductos) {
        this.context = context;
        this.listProductos = listProductos;

        datosList();
        mostrarPriductos(productos);
    }

    public void datosList(){
        String URL="https://tecnistoreaapi.rj.r.appspot.com/producto";
        //String URL=VARIABLE_GLOBAL+".ngrok.io/apiTienda/verProducto";
        JsonArrayRequest usersJSON= new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    parseJSON(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        Volley.newRequestQueue(context).add(usersJSON);
    }

    public void parseJSON(JSONArray myJSON) throws JSONException {
        for (int i =0; i<myJSON.length(); i++){

            JSONObject jsonObject= null;

            //Users user= new Users();
            Producto producto= new Producto();

            jsonObject= myJSON.getJSONObject(i);

            producto.setNombre(jsonObject.getString("nombre"));
            producto.setDescripcion(jsonObject.getString("descripcion"));
            producto.setStock(jsonObject.getInt("stock"));
            producto.setPrecio("$"+String.valueOf(jsonObject.getDouble("precio")));
            producto.setFotoUrl(jsonObject.getString("fotoUrl"));

            productos.add(producto);

        }
        productoAdapter.notifyDataSetChanged();
    }

    private void mostrarPriductos(List<Producto> DataList) {
       //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context, 2);
        listProductos.setLayoutManager(layoutManager);
        productoAdapter = new ProductoAdapter(context,DataList);
        listProductos.setAdapter(productoAdapter);
    }

}
