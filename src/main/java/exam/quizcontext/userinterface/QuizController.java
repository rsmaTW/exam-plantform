package exam.quizcontext.userinterface;

import exam.quizcontext.application.CreateQuizCommand;
import exam.quizcontext.application.QuizService;
import exam.quizcontext.application.UpdateQuizCommand;
import exam.quizcontext.domain.model.blankquiz.BlankQuiz;
import exam.quizcontext.domain.model.blankquiz.BlankQuizId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/blank-quizzes")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    BlankQuizDTO create(@RequestBody CreateQuizCommand command) {
        final BlankQuizId blankQuizId = quizService.create(command);
        return BlankQuizDTO.from(blankQuizId);
    }

    @GetMapping("/blank-quizzes")
    List<BlankQuiz> getAll() {
        return quizService.getAll();
    }

    @PutMapping("/blank-quizzes/{blankQuizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@PathVariable String blankQuizId, @RequestBody UpdateQuizCommand command) {
        quizService.update(new BlankQuizId(blankQuizId), command);
    }

    @DeleteMapping("/blank-quizzes/{blankQuizId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable String blankQuizId) {
        quizService.delete(new BlankQuizId(blankQuizId));
    }

}
