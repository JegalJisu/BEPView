package name.beptest.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


// https://bamdule.tistory.com/40
@Entity
@Table(name = "TEST_TBL")
public class TestDTO {
	
	@Id
	@Column(name = "seq_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seqNo;
	
	@Column(length = 20, nullable = true)
	private String text;
	
	@Column
	private Integer num;


	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}
