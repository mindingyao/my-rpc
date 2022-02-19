package top.mindingyao.api;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ByeObject implements Serializable {
    private String response;
    private String message;
}
