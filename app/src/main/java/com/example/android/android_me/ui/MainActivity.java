/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

// This activity is responsible for displaying the master list of all images
// Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{
    private int headIndex;
    private int bodyIndex;
    private int legsIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {
        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        int typeOfBodyPart = position/12; //as int will only store 0 1 2 (as we have 35 in list)
        int indexPosition = position - 12*typeOfBodyPart; // this calcuated the correct index position within the body type

        //assign the correct index to the correct body part
        switch (typeOfBodyPart){
            case 0:
                headIndex = indexPosition;
                break;
            case 1:
                bodyIndex = indexPosition;
                break;
            case 2:
                legsIndex = indexPosition;
                break;
            default:
                break;
        }

        Bundle data = new Bundle();
        data.putInt("headPart", headIndex);
        data.putInt("bodyPart", bodyIndex);
        data.putInt("legPart", legsIndex);

        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(data);
        // Complete (2) Based on where a user has clicked, store the selected list index for the head, body, and leg BodyPartFragments
        Button btn = (Button) findViewById(R.id.btn_next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        // Complete(3) Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity

        // Complete (4) Get a reference to the "Next" button and launch the intent when this button is clicked

    }

}
