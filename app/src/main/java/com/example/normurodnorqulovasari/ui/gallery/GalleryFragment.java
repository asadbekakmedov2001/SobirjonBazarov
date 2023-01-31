package com.example.normurodnorqulovasari.ui.gallery;

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

import com.example.normurodnorqulovasari.MainActivity4;
import com.example.normurodnorqulovasari.R;
import com.example.normurodnorqulovasari.databinding.FragmentGalleryBinding;


import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment implements UserAdapter.SelectedUser{

    private FragmentGalleryBinding binding;
    RecyclerView recyclerView2;
    List<ModelRcycler> modelRcyclers = new ArrayList<>();
    UserAdapter userAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView2 = root.findViewById(R.id.recyclerView2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView2.addItemDecoration(new DividerItemDecoration(requireContext(),0));

        initial();

        userAdapter  = new UserAdapter(modelRcyclers, this);
        recyclerView2.setAdapter(userAdapter);



        return root;
    }
    private void initial() {

        modelRcyclers.add(new ModelRcycler(R.drawable.video,"1-video. Number Theory | Divisibility Basics","We present some basics of divisibility from elementary number theory...","Wg-JlvBVPi0"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"2-video. Number Theory: The Division Algorithm","In this video, we present a proof of the division algorithm and some examples of it in practice....","qEaxFxUK-es"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"3-video. Number Theory: The Euclidean Algorithm Proof","We present a proof of the Euclidean algorithm...","8cikffEcyPI"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"4-video. Number Theory: The Euclidean Algorithm Example 1","We compute the gcd of two numbers using the Euclidean algorithm...","_EGMgO1F4RI"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"5-video. Number Theory: The Euclidean Algorithm Example 2","We compute the gcd of two numbers using the Euclidean algorithm...","x935qXueQnA"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"6-video. Number Theory | Extended Euclidean Algorithm Example #1","We use the extended Euclidean algorithm to write the greatest common divisor of two natural numbers as a linear combination of them...","f1wP28zeM3w"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"7-video. Number Theory | Extended Euclidean Algorithm Example 2","We use the extended Euclidean algorithm to write the greatest common divisor of two natural numbers as a linear combination of them...","jywBOj-0r2E"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"8-video. Number Theory | Linear Diophantine Equations","We explore the solvability of the linear Diophantine equation ax+by=c...","ZA5FC9ONO3A"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"9-video. Number Theory | Primitive Pythagorean Triples","We derive the structure of all primitive Pythagorean triples...","F3dR41ItmSg"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"10-video. Number Theory | Congruence Modulo n -- Definition and Examples","We define the notion of congruence modulo n among the integers...","QjTMbspAjsw"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"11-video. Number Theory | Congruence and Equivalence Classes","We prove the congruence modulo n is an equivalence relation on the set of integers and describe the equivalence classes...","BU4eHTTgoCw"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"12-video. Number Theory | Some properties of integer congruence"," We examine some basic properties of congruence modulo n among the integers...","33p04rolbHA"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"13-video. Number Theory | A property of integer congruence","We prove a certain property of integer congruence and provide some examples...","F0QOs9MUfnc"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"14-video. Number Theory | Integer Congruence Example 1"," We give a few examples involving integer congruence...","mNBCv_UU47o"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"15-video. Number Theory | Integer Congruence Example 2"," We give a few examples involving integer congruence and simplification, without using Fermat's little Theorem, Euler's theorem, or Wilson's theorem...","1DbkGWBYQNM"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"16-video. Number Theory | When does a linear congruence have a solution??","We give the proof of a proposition regarding linear congruences and their solvability...","ktJc8_3pKPw"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"17-video. Number Theory | Linear Congruences Proposition 2","We give the proof of a proposition regarding the number of solutions of a linear congruence...","Ob54H1oNyBA"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"18-video. Number Theory | Strategies for Solving Linear Congruence","We outline a strategy for solving linear congruences and give an example...","5JwbEQY8lvk"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"19-video. Number Theory | Inverses modulo n","We give a characterization of numbers which are invertible modulo n...","15oQQbAnr3Q"));
        modelRcyclers.add(new ModelRcycler(R.drawable.video,"20-video. Number Theory | Modular Inverses: Example","We give an example of calculating inverses modulo n using two separate strategies...","uPFh9_nLw1c"));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void selectedUser(ModelRcycler modelRcycler) {
        Intent intent = new Intent(getContext(), MainActivity4.class);
        intent.putExtra("data", modelRcycler.getLoadUrl());
        startActivity(intent);
    }
}