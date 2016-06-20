/**
  * Generated by smali2java 1.0.0.558
  * Copyright (C) 2013 Hensence.com
  */

package com.mobcent.discuz.base.widget;

import android.app.AlertDialog;
import com.mobcent.discuz.android.model.ClassifiedModel;
import android.widget.TextView;
import com.mobcent.lowest.base.utils.MCResource;
import android.content.Context;
import android.content.DialogInterface;

public class MultyChoseBuilder extends AlertDialog.Builder {
    private boolean[] checkedItems;
    private ClassifiedModel classifiedModel;
    private TextView contentText;
    private String[] items;
    private MCResource resource;
    
    public MultyChoseBuilder(Context context, String[] items, boolean[] checkedItems, TextView contentText, ClassifiedModel classifiedModel) {
        super(context);
        items = items;
        checkedItems = checkedItems;
        contentText = contentText;
        classifiedModel = classifiedModel;
        resource = MCResource.getInstance(context);
    }
    
    public AlertDialog create() {
        setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener(this) {
            
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checkedItems[which] = isChecked;
            }
        });
        setPositiveButton(resource.getStringId("mc_forum_dialog_confirm"), new DialogInterface.OnClickListener(this) {
            
            public void onClick(DialogInterface dialog, int which) {
                if((classifiedModel != null) && (!classifiedModel.equals(""))) {
                }
            }
        });
        setCancelable(true);
        return super.create();
    }
    
    private void setText() {
        String text = 0x0;
        for(int i = 0x0; i < checkedItems.length; i = i + 0x1) {
            if(checkedItems[i] != null) {
                sb.append(items[i] + ",");
                sbItem.append(i + ",");
            }
        }
        if(sb.length() > 0x1) {
            text = sb.subSequence(0x0, (sb.length() - 0x1)).toString();
            classifiedModel.setClassifiedValue(sbItem.subSequence(0x0, (sbItem.length() - 0x1)).toString());
            contentText.setText(text);
            return;
        }
        if(classifiedModel != null) {
            classifiedModel.setClassifiedValue("");
            contentText.setText("");
        }
    }
}
