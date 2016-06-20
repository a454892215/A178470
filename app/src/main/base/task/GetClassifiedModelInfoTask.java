/**
  * Generated by smali2java 1.0.0.558
  * Copyright (C) 2013 Hensence.com
  */

package com.mobcent.discuz.base.task;

import android.os.AsyncTask;
import android.content.Context;
import com.mobcent.discuz.activity.view.MCPublishClassifyView;
import com.mobcent.discuz.android.model.BaseResultModel;
import java.util.List;
import com.mobcent.discuz.android.model.ClassifiedModel;
import com.mobcent.discuz.android.service.impl.PostsServiceImpl;
import com.mobcent.lowest.base.utils.MCToastUtils;
import com.mobcent.lowest.base.utils.MCStringUtil;
import com.mobcent.lowest.base.utils.MCListUtils;

public class GetClassifiedModelInfoTask extends AsyncTask {
    private long boardId;
    private int classificationTopId;
    private Context context;
    private MCPublishClassifyView mcPublishClassifyView;
    
    public GetClassifiedModelInfoTask(Context context, long boardId, int classificationTopId, MCPublishClassifyView mcPublishClassifyView) {
        context = context;
        boardId = boardId;
        classificationTopId = classificationTopId;
        mcPublishClassifyView = mcPublishClassifyView;
    }
    
    protected BaseResultModel<List<ClassifiedModel>> doInBackground(Integer params) {
        return new PostsServiceImpl(context).getClassifiedModleList(classificationTopId, boardId);
    }
    
    protected void onPostExecute(BaseResultModel<List<ClassifiedModel>> result) {
        super.onPostExecute(result);
        if(result == null) {
            MCToastUtils.toastByResName(context.getApplicationContext(), "mc_forum_no_info");
            return;
        }
        if(!MCStringUtil.isEmpty(result.getErrorInfo())) {
            MCToastUtils.toastByResName(context.getApplicationContext(), result.getErrorInfo());
            return;
        }
        if(!MCListUtils.isEmpty((List)result.getData())) {
            mcPublishClassifyView.setClassifiedModelList((List)result.getData());
            mcPublishClassifyView.createView();
        }
    }
}
