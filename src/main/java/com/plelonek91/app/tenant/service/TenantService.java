package com.plelonek91.app.tenant.service;

import com.plelonek91.app.tenant.entity.Tenant;

public interface TenantService {
    Tenant getTenantById(Long tenantId);
}
