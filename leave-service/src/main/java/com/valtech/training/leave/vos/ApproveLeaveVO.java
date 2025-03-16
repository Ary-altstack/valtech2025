package com.valtech.training.leave.vos;

// manager will approve the leave with the *leaveId,

public record ApproveLeaveVO (long leaveId,String comments,long manager) {
	
}

