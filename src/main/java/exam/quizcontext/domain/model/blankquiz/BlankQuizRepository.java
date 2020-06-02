package exam.quizcontext.domain.model.blankquiz;

import java.util.List;

public interface BlankQuizRepository {
    BlankQuiz find(BlankQuizId blankQuizId);

    void save(BlankQuiz blankQuiz);

    BlankQuizId nextBlankQuiz();

    List<BlankQuiz> getAll();
}
