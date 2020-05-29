package exam.quizcontext.userinterface;

import exam.quizcontext.domain.model.blankquiz.BlankQuizId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlankQuizDTO {
    private String uri;

    public static BlankQuizDTO from(BlankQuizId blankQuizId) {
        return new BlankQuizDTO("blank-quizzes/" + blankQuizId);
    };
}
