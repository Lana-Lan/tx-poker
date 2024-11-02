package com.marchgoose.txpoker.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author steeveen
 * @date 2024/11/2 16:24
 */
@Data
@NoArgsConstructor
public class User {
    private String sessionId;
    private String userName;
    private String userId;
}
