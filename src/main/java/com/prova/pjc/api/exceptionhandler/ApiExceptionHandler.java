package com.prova.pjc.api.exceptionhandler;

import com.fasterxml.jackson.databind.JsonMappingException.Reference;
;
import com.prova.pjc.api.domain.exception.EntidadeEmUsoException;
import com.prova.pjc.api.domain.exception.EntidadeNaoEncontradaException;
import com.prova.pjc.api.domain.exception.NegocioException;
import com.prova.pjc.api.domain.exception.TipoAlbumNaoEncontradoException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler  extends ResponseEntityExceptionHandler {


    public static final String MSG_ERRO_GENERICA_USUARIO_FINAL
            = "Ocorreu um erro interno inesperado no sistema. Tente novamente e se "
            + "o problema persistir, entre em contato com o administrador do sistema.";


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        ErrorType errorType = ErrorType.DADOS_INVALIDOS;
        String detail = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";

        BindingResult bindingResult = ex.getBindingResult();

        List<FormataMsgErroException.Field> problemFields = bindingResult.getFieldErrors().stream()
                .map(fieldError -> FormataMsgErroException.Field.builder()
                        .name(fieldError.getField())
                        .userMessage(fieldError.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());

        FormataMsgErroException msgError = createProblemBuilder(status, errorType, detail)
                .userMessage(detail)
                .fields(problemFields)
                .build();

        return handleExceptionInternal(ex, msgError, headers, status, request);
    }




    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        ErrorType errorType = ErrorType.MENSAGEM_INCOMPREENSIVEL;
        String detail = "O corpo da requisição está inválido. Verifique erro de sintaxe.";

        FormataMsgErroException msgError = createProblemBuilder(status, errorType, detail).build();

        // o ideal
        // é repassar o "headers" que recebemos como argumento do método
        // return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);

        return handleExceptionInternal(ex, msgError, headers, status, request);
    }


    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> handleEntidadeNaoEncontradaException(
            EntidadeNaoEncontradaException ex, WebRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorType errorType = ErrorType.ENTIDADE_NAO_ENCONTRADA;
        String detail = ex.getMessage();

        FormataMsgErroException msgError = createProblemBuilder(status, errorType, detail)
                .userMessage(detail)
                .build();

        return handleExceptionInternal(ex, msgError, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(EntidadeEmUsoException.class)
    public ResponseEntity<?> handleEntidadeEmUsoException(
            EntidadeEmUsoException ex, WebRequest request) {

        HttpStatus status = HttpStatus.CONFLICT;
        ErrorType errorType = ErrorType.ENTIDADE_EM_USO;
        String detail = ex.getMessage();

        FormataMsgErroException msgError = createProblemBuilder(status, errorType, detail)
                .userMessage(detail)
                .build();

        return handleExceptionInternal(ex, msgError, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<?> handleNegocioException(NegocioException ex, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorType errorType = ErrorType.ERRO_NEGOCIO;
        String detail = ex.getMessage();

        FormataMsgErroException msgError = createProblemBuilder(status, errorType, detail)
                .userMessage(detail)
                .build();

        return handleExceptionInternal(ex, msgError, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(TipoAlbumNaoEncontradoException.class)
    public ResponseEntity<?> handleTipoAlbumNaoEncontradoException(
            TipoAlbumNaoEncontradoException ex, WebRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorType errorType = ErrorType.ENTIDADE_NAO_ENCONTRADA;
        String detail = ex.getMessage();

        FormataMsgErroException msgError = createProblemBuilder(status, errorType, detail)
                .userMessage(detail)
                .build();

        return handleExceptionInternal(ex, msgError, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {

        if (body == null) {
            body = FormataMsgErroException.builder()
                    .timestamp(LocalDateTime.now())
                    .title(status.getReasonPhrase())
                    .status(status.value())
                    .userMessage(MSG_ERRO_GENERICA_USUARIO_FINAL)
                    .build();
        } else if (body instanceof String) {
            body = FormataMsgErroException.builder()
                    .timestamp(LocalDateTime.now())
                    .title((String) body)
                    .status(status.value())
                    .userMessage(MSG_ERRO_GENERICA_USUARIO_FINAL)
                    .build();
        }
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }



    private FormataMsgErroException.FormataMsgErroExceptionBuilder createProblemBuilder(HttpStatus status,
                                                                                                                           ErrorType problemType, String detail) {
        return FormataMsgErroException.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .type(problemType.getUri())
                .title(problemType.getTitle())
                .detail(detail);
    }


    private String joinPath(List<Reference> references) {
        return references.stream()
                .map(ref -> ref.getFieldName())
                .collect(Collectors.joining("."));
    }




}
