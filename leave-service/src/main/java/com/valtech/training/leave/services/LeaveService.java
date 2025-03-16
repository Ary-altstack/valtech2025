package com.valtech.training.leave.services;

import java.util.List;

import com.valtech.training.leave.vos.ApproveLeaveVO;
import com.valtech.training.leave.vos.LeaveMasterVO;
import com.valtech.training.leave.vos.LeaveVO;

public interface LeaveService {

	List<LeaveMasterVO> getAllLeaveMasters();

	LeaveMasterVO getLeaveMaster(long employeeId);

	LeaveMasterVO saveOrUpdateLeaveMaster(LeaveMasterVO vo);

	List<LeaveVO> getAllLeaves();

	LeaveVO getLeave(long id);

	LeaveVO saveOrUpdateLeave(LeaveVO vo);

	List<LeaveVO> getLeavesByEmployees(long emp);

	LeaveVO update(LeaveVO vo, long id);

	LeaveVO applyLeave(LeaveVO vo);

	LeaveVO approveLeave(ApproveLeaveVO vo);

}