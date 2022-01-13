package com.pro.pro.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InternetTestDTO {

    @NonNull
    private float download_speed;

    @NonNull
    private float upload_speed;
}
