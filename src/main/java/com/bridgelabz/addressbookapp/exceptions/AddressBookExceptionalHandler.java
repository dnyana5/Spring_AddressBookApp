package com.bridgelabz.addressbookapp.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class AddressBookExceptionalHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handlerMethodArgumentNotValidException(
      MethodArgumentNotValidException exceptions){
      List<ObjectError> errorList = exceptions.getBindingResult().getAllErrors();
      List<String> errMesg = errorList.stream()
                              .map(objErr -> objErr.getDefaultMessage())
                              .collect(Collectors.toList());
      ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request",errMesg);
      return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(AddressBookException.class)
    public ResponseEntity<ResponseDTO> handleAddressBookException(
        AddressBookException exception){
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request",
                                    exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
