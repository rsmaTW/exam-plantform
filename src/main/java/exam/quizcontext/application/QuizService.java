package exam.quizcontext.application;

import exam.quizcontext.domain.model.blankquiz.BlankQuiz;
import exam.quizcontext.domain.model.blankquiz.BlankQuizId;
import exam.quizcontext.domain.model.blankquiz.BlankQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    private BlankQuizRepository blankQuizRepository;

    @Autowired
    public QuizService(BlankQuizRepository blankQuizRepository) {
        this.blankQuizRepository = blankQuizRepository;
    }

    public BlankQuizId create(CreateQuizCommand command) {

        final String question = command.getQuestion();
        final String answer = command.getAnswer();

        final BlankQuizId blankQuizId = blankQuizRepository.nextBlankQuiz();

        final exam.quizcontext.domain.model.blankquiz.BlankQuiz
                blankQuiz = exam.quizcontext.domain.model.blankquiz.BlankQuiz.create(blankQuizId, question, answer);
        blankQuizRepository.save(blankQuiz);

        return blankQuizId;
    }

    public List<BlankQuiz> getAll() {
        return blankQuizRepository.getAll();
    }

    public void update(BlankQuizId blankQuizId, UpdateQuizCommand command) {

        final BlankQuiz blankQuiz = blankQuizRepository.find(blankQuizId);
        blankQuiz.update(command.getQuestion(), command.getAnswer());

        blankQuizRepository.save(blankQuiz);
    }

    public void delete(BlankQuizId blankQuizId) {
        final BlankQuiz blankQuiz = blankQuizRepository.find(blankQuizId);
        blankQuiz.delete();
        blankQuizRepository.save(blankQuiz);
    }
}
