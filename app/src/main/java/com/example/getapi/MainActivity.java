package com.example.getapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.getapi.Adapter.Recycleadpter;
import com.example.getapi.Model.Addres;
import com.example.getapi.Model.Company;
import com.example.getapi.Model.Modelclass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Modelclass> modelclassList = new ArrayList<>();
    List<Addres> addresList=new ArrayList<>();
    List<Company> companyList=new ArrayList<>();

    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         recyclerView=findViewById(R.id.showdata);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/users",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray=new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++)
                            {
                                JSONObject userobject = jsonArray.getJSONObject(i);
                                int id=userobject.getInt("id");
                                String name=userobject.getString("name");
                                String username=userobject.getString("username");
                                String email=userobject.getString("email");
                                String phone=userobject.getString("phone");
                                String website=userobject.getString("website");

                                Modelclass modelclass=new Modelclass(id,name,username,email,phone,website);
                                modelclassList.add(modelclass);


                                JSONObject addresobj = userobject.getJSONObject("address");
                                String street=addresobj.getString("street");
                                String suite=addresobj.getString("suite");
                                String city=addresobj.getString("city");
                                String zipcode=addresobj.getString("zipcode");

                                Addres addres=new Addres(street,suite,city,zipcode);
                                addresList.add(addres);

                                JSONObject companyobj = userobject.getJSONObject("company");
                                String cname=companyobj.getString("name");
                                String catchPhrase=companyobj.getString("catchPhrase");
                                String bs=companyobj.getString("bs");

                                Company company=new Company(name,catchPhrase,bs);
                                companyList.add(company);

                                System.out.println(name);

                            }
                            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            Recycleadpter data=  new Recycleadpter(MainActivity.this,modelclassList,addresList,companyList);
                            recyclerView.setAdapter(data);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

        requestQueue.add(stringRequest);
    }
}