package com.netbanking.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;

import com.netbanking.resources.NetBanking;

@ApplicationPath("/api/*")
public class NetBankingApplication extends javax.ws.rs.core.Application {
	private Set<Object> singletons;
	//verifying with the singleton scope.
@Override
public Set<Object> getSingletons() {
	System.out.println("inside getSingletons method");
	return singletons;
}
	public NetBankingApplication() {
		System.out.println("inside NetBankingApplication");
		singletons = new HashSet<Object>();
		singletons.add(new NetBanking("Hi"));
	}
}
