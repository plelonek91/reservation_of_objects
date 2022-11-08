package com.plelonek91.app.tenant.service;


import com.plelonek91.app.tenant.entity.Tenant;
import com.plelonek91.app.tenant.repository.TenantRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    @Override
    public Tenant getTenantById(Long tenantId) {
        return tenantRepository.findById(tenantId).get();
    }
}
