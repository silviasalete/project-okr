package com.okr.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.okr.controller.Action;
import com.okr.model.bean.KeyResult;
import com.okr.model.dao.KeyResultDAO;

public class UpdateKeyResult implements Action {

	@Override
	public String performe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String description = request.getParameter("description");
		String userId      = request.getParameter("userId");
		String keyResultId = request.getParameter("keyResultId");
		String idObjective = request.getParameter("idObjective");

		KeyResultDAO keyResultDAO = new KeyResultDAO();
		KeyResult keyResult = keyResultDAO.getKeyResultByIdUserObjectiveKeyResult(Integer.parseInt(userId),Integer.parseInt(idObjective),Integer.parseInt(keyResultId));
		keyResult.setDescription(description);
		
		return keyResultDAO.updateKeyResult(keyResult)?"redirect:?action=Welcome":"redirect:?action=KeyResultFormUpdate";
	}

}
