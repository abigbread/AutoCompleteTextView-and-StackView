package com.bread.stackview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    StackView stackView;
    AutoCompleteTextView autoTV;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    int[] imgs = new int[]{
            R.drawable.home_icon_1, R.drawable.home_icon_2, R.drawable.home_icon_3, R.drawable.home_icon_4
    };
    String[] str = new String[]{"我是谁","我是谁我是谁","我是谁我是谁我是谁","我是谁我是谁我是谁我是谁"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoTV = (AutoCompleteTextView) findViewById(R.id.auto);
        stackView = (StackView) findViewById(R.id.stack_view);
        multiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.auto_multi);

        List<Map<String, Integer>> list = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            map.put("img", imgs[i]);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.cell, new String[]{"img"}, new int[]{R.id.image});
        stackView.setAdapter(adapter);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,str);
        autoTV.setAdapter(adapter2);
        multiAutoCompleteTextView.setAdapter(adapter2);
        //设置分隔符“ ，”
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }

    public void prev(View v){
        stackView.showPrevious();
    }
    public void next(View v){
        stackView.showNext();
    }

}
