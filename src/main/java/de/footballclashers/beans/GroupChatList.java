package de.footballclashers.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupChatList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4570423427745410567L;

	private Status status;

	private List<GroupChat> chatDetails;

	public GroupChatList() {
		chatDetails = new ArrayList<GroupChat>();
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<GroupChat> getChatDetails() {
		return chatDetails;
	}

	public void setChatDetails(List<GroupChat> chatDetails) {
		this.chatDetails = chatDetails;
	}
}
