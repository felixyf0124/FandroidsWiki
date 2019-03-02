package org.wikipedia.citation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.wikipedia.R;

public class CitationActivity extends AppCompatActivity {

    private RadioGroup citationStyleGroup;
    private RadioButton citationStyleBtn;

    private RadioButton citationStyleBtn_APA;
    private RadioButton citationStyleBtn_MLA;
    private RadioButton citationStyleBtn_IEEE;

    private CheckBox citationLaTeXBtn;

    //private RadioGroup.OnCheckedChangeListener radio_group_listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.page_toolbar);
        setSupportActionBar(toolbar);

        citationStyleGroup = (RadioGroup) findViewById(R.id.citation_radiogroup_btn);
        citationStyleBtn_APA = citationStyleGroup.findViewById(R.id.button_apa);
        citationStyleBtn_MLA = citationStyleGroup.findViewById(R.id.button_mla);
        citationStyleBtn_IEEE = citationStyleGroup.findViewById(R.id.button_ieee);
        citationLaTeXBtn = findViewById(R.id.button_latex);
        setCitationStyleBtnBG(R.id.button_apa);
        setCitationLaTeXBtnBG(false);

        addListenerOnRadioGroupButton();
        addListenerOnCheckButton();

    }


    public void addListenerOnRadioGroupButton() {


        //citationStyleBtn = (Button) findViewById(R.id.citationStyleBtn);

        citationStyleGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                citationStyleBtn = group.findViewById(checkedId);

                if (citationStyleBtn != null && checkedId > -1) {
                    setCitationStyleBtnBG(checkedId);
                    Toast.makeText(CitationActivity.this, citationStyleBtn.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // this is for the button style change
    public void setCitationStyleBtnBG(int checkedId){
        if(checkedId == R.id.button_apa)
        {
            citationStyleBtn_APA.setBackgroundResource(R.drawable.citation_style_button_selected);
            citationStyleBtn_MLA.setBackgroundResource(R.drawable.citation_style_button_unselected);
            citationStyleBtn_IEEE.setBackgroundResource(R.drawable.citation_style_button_unselected);
            citationStyleBtn_APA.setTextColor(R.color.color_state_black);
            citationStyleBtn_MLA.setTextColor(R.color.color_state_white);
            citationStyleBtn_IEEE.setTextColor(R.color.color_state_white);

        }
        if(checkedId == R.id.button_mla)
        {
            citationStyleBtn_APA.setBackgroundResource(R.drawable.citation_style_button_unselected);
            citationStyleBtn_MLA.setBackgroundResource(R.drawable.citation_style_button_selected);
            citationStyleBtn_IEEE.setBackgroundResource(R.drawable.citation_style_button_unselected);
            citationStyleBtn_APA.setTextColor(R.color.color_state_white);
            citationStyleBtn_MLA.setTextColor(R.color.color_state_black);
            citationStyleBtn_IEEE.setTextColor(R.color.color_state_white);
        }
        if(checkedId == R.id.button_ieee)
        {
            citationStyleBtn_APA.setBackgroundResource(R.drawable.citation_style_button_unselected);
            citationStyleBtn_MLA.setBackgroundResource(R.drawable.citation_style_button_unselected);
            citationStyleBtn_IEEE.setBackgroundResource(R.drawable.citation_style_button_selected);
            citationStyleBtn_APA.setTextColor(R.color.color_state_white);
            citationStyleBtn_MLA.setTextColor(R.color.color_state_white);
            citationStyleBtn_IEEE.setTextColor(R.color.color_state_black);
        }
    }

    public void addListenerOnCheckButton() {


        //citationStyleBtn = (Button) findViewById(R.id.citationStyleBtn);

        citationLaTeXBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setCitationLaTeXBtnBG(isChecked);
            }
        } );
    }

    // this is for the button style change
    public void setCitationLaTeXBtnBG(boolean isChecked){
        if (isChecked)
        {
            citationLaTeXBtn.setBackgroundResource(R.drawable.citation_style_button_selected);
            citationLaTeXBtn.setTextColor(R.color.color_state_black);
        }
        else {
            citationLaTeXBtn.setBackgroundResource(R.drawable.citation_style_button_unselected);
            citationLaTeXBtn.setTextColor(R.color.color_state_white);
        }
    }
}