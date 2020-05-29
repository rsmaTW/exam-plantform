package exam.quizcontext.infrastructure;

import exam.quizcontext.domain.model.blankquiz.BlankQuiz;
import exam.quizcontext.domain.model.blankquiz.BlankQuizId;
import exam.quizcontext.domain.model.blankquiz.BlankQuizRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
public class MemoryQuizRepository implements BlankQuizRepository {
    private final Map<BlankQuizId, BlankQuiz> blankQuizzes = new HashMap<>();

    @Override
    public BlankQuiz find(BlankQuizId blankQuizId) {
        return Optional.ofNullable(blankQuizzes.get(blankQuizId))
                .orElseThrow(NullPointerException::new);
    }

    @Override
    public void save(BlankQuiz blankQuiz) {
        blankQuizzes.put(blankQuiz.getBlankQuizId(), blankQuiz);
    }

    @Override
    public BlankQuizId nextBlankQuiz() {
        return new BlankQuizId("blankQuiz-" + UUID.randomUUID().toString());
    }

    @Override
    public List<BlankQuiz> getAll() {
        return new ArrayList<>(blankQuizzes.values());
    }

    @Override
    public void delete(BlankQuizId blankQuizId) {

        blankQuizzes.remove(blankQuizId);
    }
}
