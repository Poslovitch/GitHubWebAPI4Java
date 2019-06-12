package io.github.TheBusyBiscuit.GitHubWebAPI4Java;

import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.github.TheBusyBiscuit.GitHubWebAPI4Java.annotations.GitHubAccessPoint;
import io.github.TheBusyBiscuit.GitHubWebAPI4Java.extra.GitHubDate;

public class RepositoryFeature extends UniqueGitHubObject {

	public RepositoryFeature(GitHubWebAPI api, GitHubObject parent, String suffix) {
		super(api, parent, suffix);
	}

	public RepositoryFeature(GitHubObject obj) {
		super(obj);
	}
	
	@GitHubAccessPoint(path = "@number", type = Integer.class, requiresAccessToken = false)
	public int getNumber() throws IllegalAccessException {
		JsonElement element = getResponse(false);
		
		if (element == null) {
			throw new IllegalAccessException("Could not connect to '" + getURL() + "'");
		}
		JsonObject response = element.getAsJsonObject();
		
		return isInvalid(response, "number") ? null: response.get("number").getAsInt();
	}

	@GitHubAccessPoint(path = "@title", type = String.class, requiresAccessToken = false)
	public String getTitle() throws IllegalAccessException {
		JsonElement element = getResponse(false);
		
		if (element == null) {
			throw new IllegalAccessException("Could not connect to '" + getURL() + "'");
		}
		JsonObject response = element.getAsJsonObject();

		return isInvalid(response, "title") ? null: response.get("title").getAsString();
	}

	@GitHubAccessPoint(path = "@state", type = State.class, requiresAccessToken = false)
	public State getState() throws IllegalAccessException {
		JsonElement element = getResponse(false);
		
		if (element == null) {
			throw new IllegalAccessException("Could not connect to '" + getURL() + "'");
		}
		JsonObject response = element.getAsJsonObject();

		return isInvalid(response, "state") ? null: State.valueOf(response.get("state").getAsString().toUpperCase());
	}
	
	@GitHubAccessPoint(path = "@closed_at", type = Date.class, requiresAccessToken = false)
	public Date getClosedDate() throws IllegalAccessException {
		JsonElement element = getResponse(true);
		
		if (element == null) {
			throw new IllegalAccessException("Could not connect to '" + getURL() + "'");
		}
		JsonObject response = element.getAsJsonObject();

		return isInvalid(response, "closed_at") ? null: GitHubDate.parse(response.get("closed_at").getAsString());
	}
	
	public static enum State {
		
		OPEN,
		CLOSED;
		
	}

}
