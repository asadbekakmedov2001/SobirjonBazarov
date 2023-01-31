package com.example.normurodnorqulovasari.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.normurodnorqulovasari.MainActivity2;
import com.example.normurodnorqulovasari.MainActivity3;
import com.example.normurodnorqulovasari.R;
import com.example.normurodnorqulovasari.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements UserAdapter.SelectedUser {

    private FragmentHomeBinding binding;

    RecyclerView recyclerView;
    List<ModelRcycler> modelRcyclers = new ArrayList<>();
    UserAdapter userAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // ruyhatni eloni va sozlanmasi
        recyclerView = root.findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(),0));

        initial();

        userAdapter  = new UserAdapter(modelRcyclers,  this);
        recyclerView.setAdapter(userAdapter);


        return root;
    }

    private void initial() {
        modelRcyclers.add(new ModelRcycler(R.drawable.auuuu,"Kirish","Jahon adabiyotshunosligida badiiylik mezonlarining taraqqiyoti va izchil takomillashuvi badiiy tafakkurning tadrijiy rivoji  bilan uzviy bog‘liq bo‘lib...","https://github.com/asadbekakmedov2001/SobirjonBazarov/raw/main/app/src/main/assets/kirish.docx"));
        modelRcyclers.add(new ModelRcycler(R.drawable.auuuu,"I BOB. Adib hikoyalarida xarakter va milliy ruh","",""));
        modelRcyclers.add(new ModelRcycler(R.drawable.auuuu,"II.BOB. Normurod Norqobil asarlarining o‘ziga xos jihatlari","",""));
        modelRcyclers.add(new ModelRcycler(R.drawable.auuuu,"HULOSA","Xarakterlarni  individuallashtirishda obrazning tashqi ko‘rinish chizgilari, ya’ni portretga ham alohida ahamiyat berish Normurod Norqobilov...","https://github.com/asadbekakmedov2001/SobirjonBazarov/raw/main/app/src/main/assets/hulosa.docx"));
        modelRcyclers.add(new ModelRcycler(R.drawable.auuuu,"ADABIYOTLAR","Abdug‘afurov A. Qalb qa’ridagi qadriyatlar. – T.: O‘qituvchi, 1998. – 215 b.\n" +
                "Adabiyot nazariyasi. Ikki tomlik. I tom (Adabiy asar). – T.: Fan, 1978. –  416 b.\n","https://github.com/asadbekakmedov2001/SobirjonBazarov/raw/main/app/src/main/assets/adabiyotlar.docx"));


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void selectedUser(ModelRcycler modelRcycler) {

        if (modelRcycler.getLessonName().toLowerCase().startsWith("kirish") ||
                modelRcycler.getLessonName().toLowerCase().startsWith("hulosa") ||
                modelRcycler.getLessonName().toLowerCase().startsWith("adabiyot")
        ){
//
            startActivity(new Intent(getContext(), MainActivity3.class).putExtra("data",modelRcycler.getLoadUrl()));
        }
        else {

            startActivity(new Intent(getContext(), MainActivity2.class).putExtra("swimmers",modelRcyclers.indexOf(modelRcycler)));


        }

    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        modelRcyclers.clear();
//    }

    @Override
    public void onStart() {
        super.onStart();
        modelRcyclers.clear();
        initial();
    }
}