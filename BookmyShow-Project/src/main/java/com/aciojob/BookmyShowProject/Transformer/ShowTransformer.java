package com.aciojob.BookmyShowProject.Transformer;

import com.aciojob.BookmyShowProject.DTOS.AddShowRequest;
import com.aciojob.BookmyShowProject.Models.Show;

public class ShowTransformer {
    public static Show convertAddShowRequestToShowEntity(AddShowRequest addShowRequest){
        Show obj=Show.builder()
                .showDate(addShowRequest.getShowDate())
                .releaseTime(addShowRequest.getRelaeseTime())
                .build();
        return obj;
    }
}
