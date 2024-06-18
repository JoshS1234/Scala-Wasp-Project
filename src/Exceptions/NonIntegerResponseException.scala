package Exceptions

class NonIntegerResponseException extends RuntimeException("This is not a valid integer response") {
  val statusCode = 400;
}
