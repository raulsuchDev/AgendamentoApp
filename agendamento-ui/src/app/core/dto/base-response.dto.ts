export interface BaseResponse<T> {
    statusCode: string;
    message: string;
    resBody?: T;
}