package org.pgm.jpaboard.upload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadResultDTO {
    private String uuid;
    private String filename;
    private boolean imageFlag;

    public String getLink() {
        if(imageFlag) {
            return "s_" + this.uuid + "_" + this.filename;
        } else {
            return this.uuid + "_" + this.filename;
        }
    }
}
