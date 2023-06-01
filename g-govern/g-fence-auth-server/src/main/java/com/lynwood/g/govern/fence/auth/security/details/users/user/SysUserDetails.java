package com.lynwood.g.govern.fence.auth.security.details.users.user;

import com.lynwood.g.govern.fence.auth.security.details.users.MultiUsersBaseDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author： Lynwood
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserDetails extends MultiUsersBaseDetails {
    private String others;
}
