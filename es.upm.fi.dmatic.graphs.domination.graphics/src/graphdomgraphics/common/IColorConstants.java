/**
 * 
 */
package graphdomgraphics.common;

import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

/**
 * @author xIS02028
 *
 */
public interface IColorConstants {

	public IColorConstant NODE_TEXT_FOREGROUND = IColorConstant.BLACK;
	public IColorConstant NODE_FOREGROUND = IColorConstant.BLACK;
	public IColorConstant NODE_BACKGROUND = new ColorConstant(0, 153, 255);
	public IColorConstant NODE_FOREGROUND_DOMINATING =IColorConstant.BLACK;
	public IColorConstant NODE_BACKGROUND_DOMINATING = IColorConstant.RED;
	public IColorConstant NODE_FOREGROUND_DOMINATED = IColorConstant.BLACK;
	public IColorConstant NODE_BACKGROUND_DOMINATED = IColorConstant.GREEN;;
	
	public IColorConstant EDGE_FOREGROUND = IColorConstant.BLACK;
	public IColorConstant EDGE_BACKGROUND = IColorConstant.BLACK;
	public IColorConstant EDGE_FOREGROUND_DOMINATING = IColorConstant.RED;
	public IColorConstant EDGE_BACKGROUND_DOMINATING = IColorConstant.RED;
}
