package io.github.TheBusyBiscuit.GitHubWebAPI4Java.objects.repositories;

import com.google.gson.JsonElement;

import io.github.TheBusyBiscuit.GitHubWebAPI4Java.GitHubWebAPI;
import io.github.TheBusyBiscuit.GitHubWebAPI4Java.annotations.GitHubAccessPoint;
import io.github.TheBusyBiscuit.GitHubWebAPI4Java.objects.GitHubObject;

public class GitHubFile extends GitHubObject {
	
	protected GitHubRepository repo;
	
	public GitHubFile(GitHubWebAPI api, GitHubRepository repo, String suffix) {
		super(api, repo, suffix);
		
		this.repo = repo;
	}
	
	public GitHubFile(GitHubWebAPI api, GitHubRepository repo, String suffix, JsonElement response) {
		super(api, repo, suffix);
		
		this.repo = repo;
		this.minimal = response;
	}

	public GitHubFile(GitHubObject obj) {
		super(obj);
	}
	
	public GitHubRepository getRepository() {
		return this.repo;
	}

	@GitHubAccessPoint(path = "@sha", type = String.class, requiresAccessToken = false)
	public String getID() throws IllegalAccessException {
		return getString("sha", false);
	}

	@GitHubAccessPoint(path = "@path", type = String.class, requiresAccessToken = false)
	public String getFile() throws IllegalAccessException {
		return getString("path", false);
	}

	@GitHubAccessPoint(path = "@type", type = String.class, requiresAccessToken = false)
	public String getType() throws IllegalAccessException {
		return getString("type", false);
	}
	
	@GitHubAccessPoint(path = "@size", type = Integer.class, requiresAccessToken = false)
	public Integer getSize() throws IllegalAccessException {
		return null;
	}
}
