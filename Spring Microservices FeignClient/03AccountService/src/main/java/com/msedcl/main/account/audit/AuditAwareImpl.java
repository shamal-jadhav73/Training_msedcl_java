package com.msedcl.main.account.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
@Component(value = "auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		// Fetch currently logged-in user and set value
		return Optional.of("ACCOUNTS-MS");
	}

}
